package dio.primeira_api.controller;

import dio.primeira_api.models.Produto;
import dio.primeira_api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produto", description = "Gestão de protutos")
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(
            summary = "Listar todos os produtos",
            description = "Retorna uma lista com todos os produtos cadastrados"
    )
    @ApiResponse(responseCode = "200", description = "Sucesso")
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Operation salvar sem ID, operation update com id
    @Operation(
            summary = "Salvar ou atualizar um produto",
            description = "Cria ou atualiza um produto no banco de dados",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Sucesso",
                            content = @Content(
                                    schema = @Schema(implementation = Produto.class)
                            )
                    )
            }
    )
    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @Operation(
            summary = "Deletar um produto",
            description = "Deleta um produto do banco de dados",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "ID do produto",
                            required = true,
                            example = "1",
                            allowEmptyValue = false
                    )
            }
    )
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id){
        try{
            produtoService.deletarProduto(id);
        }catch (Exception e){
            return "Erro ao deletar produto: " + e.getMessage();
        }
        return "Produto deletado com sucesso!";
    }
}
