package repositories;

import java.util.List;

import dao.factories.IContatoDAO;
import domain.ContatoVO;

public class ContatoMySqlRepository implements IContatoRepository {

    private IContatoDAO dao;

    public ContatoMySqlRepository(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO contato) {
        dao.salvar(contato);
    }

    @Override
    public void atualizar(ContatoVO contato) {
        // TODO: Realizar chamada do método de atualização do DAO
        dao.atualizar(contato);
        System.out.println("Atualizado!!!");
    }

    @Override
    public void excluir(Integer id) {
        // TODO: Realizar chamada do método de exclusão do DAO
        dao.excluir(id);
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        // TODO: Realizar chamada do método de busca por e-mail do DAO
        ContatoVO contato = dao.buscarPorEmail(email);
        return contato;
    }

}
