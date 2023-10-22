package services;

import java.util.List;
import java.util.Objects;

import domain.ContatoVO;
import repositories.IContatoRepository;

public class ContatoService implements IContadoService {

    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(ContatoVO contato) {
        // Validar objeto conforme a entidade contatos
        if (Objects.isNull(contato.getNome()) || contato.getNome().isEmpty()) {
            throw new RuntimeException("Nome é obrigatório!");
        }

        if (Objects.isNull(contato.getEmail()) || contato.getEmail().isEmpty()) {
            throw new RuntimeException("É-mail é obrigatório!");
        }

        repository.salvar(contato);
    }

    @Override
    public void alterar(ContatoVO contato) {
        // TODO: Validar objeto conforme a entidade contatos
        // TODO: Consultar e recuperar contato
        // TODO: Alterar contato
        if (Objects.isNull(contato.getId())) {
            throw new RuntimeException("ID é obrigatório!");
        } else {
            ContatoVO achar = repository.buscarPorEmail(contato.getEmail());
            if (Objects.isNull(achar)) {
                throw new RuntimeException("Contato não encontrado!");
            } else {
                repository.atualizar(contato);
            }
        }
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        List<ContatoVO> achar = repository.buscarTodos();
        // TODO: Validar e-mail
        for (ContatoVO contato : achar) {
            if (contato.getEmail().equals(email)) {
                return contato;
            }
        }
        // TODO: Localizar contato e retornar contato
        return null;

    }

    @Override
    public void excluir(Integer id) {
        // TODO: Validar id e o id escolhido para ser deletado
        // TODO: Localizar contato e excluir contato
        List<ContatoVO> achar = repository.buscarTodos();
        for (ContatoVO contato : achar) {
            if (contato.getId().equals(id)) {
                repository.excluir(id);
            }
        }
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        // TODO: Consultar e retornar todos os contatos cadastrados
        return repository.buscarTodos();
    }

}
