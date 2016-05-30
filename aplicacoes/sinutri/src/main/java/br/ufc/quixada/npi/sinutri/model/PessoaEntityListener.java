package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;

public class PessoaEntityListener {
	
	private ApplicationContext context;
	
	//@PostLoad
	public void loadPessoa(Pessoa pessoa) {
		UsuarioService usuarioService = (UsuarioService) context.getBean(UsuarioService.class);
		Usuario usuario = usuarioService.getByCpf(pessoa.getCpf());
		pessoa.setNome(usuario.getNome());
		pessoa.setEmail(usuario.getEmail());
		pessoa.setTelefone(usuario.getTelefone());
		pessoa.setDataNascimento(usuario.getNascimento());
	}
	
	@Autowired
    public void context(ApplicationContext ctx) {
        this.context = ctx;
    }

}
