package steps;

import hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.DataStore;

import static org.hamcrest.Matchers.*;

public class RegressivoSteps {
    private JSONObject bodyCriarReserva, bodyAlterarReserva;
    private Response response;
    private int idReserva;

    @Before
    public void setup() {
        bodyCriarReserva = Hooks.lerArquivoJson("criarReserva.json");
        bodyAlterarReserva = Hooks.lerArquivoJson("alterarReserva.json");
    }

    private void criarReservaComSucesso() {
        que_desejo_criar_uma_reserva();
        realizar_a_requisição();
        deve_ser_criado_com_sucesso();
    }

    //CT001 - Criar reserva com sucesso
    @Given("que desejo criar uma reserva")
    public void que_desejo_criar_uma_reserva() {
        bodyCriarReserva.put("firstname", "Gabriel");
        bodyCriarReserva.put("lastname", "Oliveira");
        bodyCriarReserva.put("totalprice", 1299.0);
    }

    @When("realizar a requisição")
    public void realizar_a_requisição() {
        response = Hooks.criarReserva(bodyCriarReserva.toString());
    }

    @Then("deve ser criado com sucesso")
    public void deve_ser_criado_com_sucesso() {
        response.then()
                .statusCode(200)
                .body("bookingid", allOf(notNullValue(), not(emptyString())))
                .extract().response();

        idReserva = response.path("bookingid");
        DataStore.setIdReserva(idReserva);
    }

    //CT002 - Consultar reserva com sucesso
    @Given("que ao informar o id da reserva")
    public void que_ao_informar_o_id_da_reserva() {
        criarReservaComSucesso();
    }

    @When("realizar a requisição de consulta")
    public void realizar_a_requisição_de_consulta() {
        response = Hooks.consultaReserva(String.valueOf(DataStore.getIdReserva()));
    }

    @Then("deve ser consultado com sucesso")
    public void deve_ser_consultado_com_sucesso() {
        response.then()
                .statusCode(200)
                .extract().response();
    }

    //CT003 - Alterar dados da reserva com sucesso
    @Given("que ao informar informo os dados que desejo alterar")
    public void queAoInformarInformoOsDadosQueDesejoAlterar() {
        bodyAlterarReserva.put("firstname", "Alteração");
        bodyAlterarReserva.put("lastname", "Gabriel");
        bodyAlterarReserva.put("totalprice", 1300.0);
    }

    @When("realizar a requisição de alteração")
    public void realizarARequisicaoDeAlteracao() {
        criarReservaComSucesso();
        response = Hooks.alterarReserva(bodyAlterarReserva.toString(), String.valueOf(DataStore.getIdReserva()));
    }

    @Then("deve ser alterado com sucesso")
    public void deveSerAlteradoComSucesso() {
        response.then()
                .statusCode(200)
                .extract().response();
    }

    //CT004 - Deletar reserva com sucesso
    @Given("que ao informar informo os dados que desejo deletar")
    public void queAoInformarInformoOsDadosQueDesejoDeletar() {
        criarReservaComSucesso();
    }

    @When("realizar a requisição de delete")
    public void realizarARequisicaoDeDelete() {
        response = Hooks.deletarReserva(String.valueOf(DataStore.getIdReserva()));
    }

    @Then("deve ser deletado com sucesso")
    public void deveSerDeletadoComSucesso() {
        response.then()
                .statusCode(201)
                .extract().response();
    }
}