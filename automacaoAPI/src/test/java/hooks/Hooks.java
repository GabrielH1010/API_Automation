package hooks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.YamlUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {
    private static String accessToken;
    private static JSONObject body;

    public static JSONObject lerArquivoJson(String nomeArquivo) {
        String caminho = "src/test/resources/fixtures/" + nomeArquivo;
        try {
            String conteudo = new String(Files.readAllBytes(Paths.get(caminho)));
            return new JSONObject(conteudo);
        } catch (IOException erro) {
            throw new RuntimeException("Erro ao ler o arquivo JSON: " + caminho, erro);
        }
    }

    public static void gerarToken() {
        if (accessToken == null || accessToken.isEmpty()) {
            body = lerArquivoJson("gerarToken.json");
            JSONObject credenciais = body.has("map") ? body.getJSONObject("map") : body;

            Response response = RestAssured.given()
                    .relaxedHTTPSValidation()
                    .contentType(ContentType.JSON)
                    .body(credenciais.toString())
                    .post(YamlUtils.getValorAmbiente("ambientes.path.token"))
                    .then()
                    .statusCode(200)
                    .extract().response();

            accessToken = response.jsonPath().getString("token");
        }
    }
    public static Response criarReserva(String bodyJson) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .post(YamlUtils.getValorAmbiente("ambientes.path.reserva"));
    }

    public static Response consultaReserva(String idReserva) {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .get(YamlUtils.getValorAmbiente("ambientes.path.reserva") + "/" + idReserva);
    }

    public static Response alterarReserva(String bodyJson, String idReserva) {
        gerarToken();
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + accessToken)
                .body(bodyJson)
                .put(YamlUtils.getValorAmbiente("ambientes.path.reserva") + "/" + idReserva);
    }

    public static Response deletarReserva(String idReserva) {
        gerarToken();
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + accessToken)
                .delete(YamlUtils.getValorAmbiente("ambientes.path.reserva") + "/" + idReserva);
    }
}