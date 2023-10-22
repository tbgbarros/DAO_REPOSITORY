import java.sql.Connection;

import dao.factories.ConexaoFactory;
import dao.factories.ContatoMySqlDAO;
import dao.factories.IContatoDAO;
import domain.ContatoVO;
import repositories.ContatoInMemoryRepository;
import repositories.ContatoMySqlRepository;
import repositories.IContatoRepository;
import services.ContatoService;
import services.IContadoService;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * Este conjunto de instruções inicializaram as dependencias
         * para o uso do serviço de contatos utilizando o repositório
         * com o SGBD MySQL.
         */
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoMySqlDAO(conexao);
        IContatoRepository repository = new ContatoMySqlRepository(dao);
        // memory
        // IContatoRepository repository = new ContatoInMemoryRepository();

        IContadoService service = new ContatoService(repository);

        // Criar objeto ContatoVO e realizar chamada do metodo salvar do service
        ContatoVO c1 = new ContatoVO(
                null,
                "João Pedro Ferreira",
                "jpferreira@gmail.com",
                "19999997878",
                "jpferreira_li");

        // TODO: Criar mais 2 contatos.
        ContatoVO c2 = new ContatoVO(
                null,
                "Maria da Silva",
                "mariadasilva@gmail.com",
                "19987654321",
                "mariadasilva_li");

        ContatoVO c3 = new ContatoVO(
                null,
                "Carlos Santos",
                "carlossantos@gmail.com",
                "19976543210",
                "carlossantos_li");

        // Chamada do metodo de persistencia
        // TODO: Descomente o trecho abaixo para persisitir em baco de dados e consulte
        // o banco de dados
        // service.salvar(c1);
        // service.salvar(c2);
        // service.salvar(c3);

        // TODO: Exibir os contatos cadastrados
        List<ContatoVO> lista = service.buscarTodos();
        System.out.println(lista);

        // TODO: Remover o primeiro contatto criado.
        service.excluir(4);

        // TODO: Buscar e exibir o segundo contato criado com base no e-mail
        System.out.println(service.buscarPorEmail("carlossantos@gmail.com"));

        // TODO: Altere o repositório MySQL pelo repositório em memória
        // IContatoRepository repository = new ContatoInMemoryRepository();
    }
}
