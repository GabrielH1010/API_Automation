package modulos.produto;
import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do módulo de produto")
public class ProdutoTest {
    //Configurando os dados da API Rest
    private String token;
    private static final String BASE_URI = "http://165.227.93.41";
    private static final String BASE_PATH = "/lojinha";

    @BeforeEach
    public void inicializar() {
        baseURI = BASE_URI;
        basePath = BASE_PATH;

        // Obter o token do usuário
        this.token =
            given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioParaLogin())
            .when()
                .post("/v2/login")
            .then()
                .extract()
                .path("data.token");
    }

    @Test
    @DisplayName("CT001 - Validar os limites proibidos do valor do Produto igual a zero")
    public void testValidarLimitesValorProdutoIgualZero(){

        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
            .body(ProdutoDataFactory.criarProdutoValorIgualA(0.00))
        .when()
            .post("/v2/produtos")
        .then()
            .assertThat()
            .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
            .statusCode(422);
    }

    @Test
    @DisplayName("CT002 - Validar os limites proibidos do valor do Produto igual a zero")
    public void testValidarLimitesValorProdutoMaiorSeteMil(){
        given()
            .contentType(ContentType.JSON)
            .header("token", this.token)
            .body(ProdutoDataFactory.criarProdutoValorIgualA(7000.01))
        .when()
            .post("/v2/produtos")
        .then()
            .assertThat()
            .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
            .statusCode(422);
    }
}