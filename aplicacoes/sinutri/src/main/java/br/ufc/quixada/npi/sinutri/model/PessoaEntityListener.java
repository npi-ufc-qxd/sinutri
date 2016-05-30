package br.ufc.quixada.npi.sinutri.model;

import javax.persistence.PostLoad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;

public class PessoaEntityListener implements ApplicationContextAware {
	
	private static ApplicationContext context;
	
	//@PostLoad
	public void loadPessoa(Pessoa pessoa) {
		UsuarioService usuarioService = (UsuarioService) context.getBean(UsuarioService.class);
		Usuario usuario = usuarioService.getByCpf(pessoa.getCpf());
		pessoa.setNome(usuario.getNome());
		pessoa.setEmail(usuario.getEmail());
		pessoa.setTelefone(usuario.getTelefone());
		pessoa.setDataNascimento(usuario.getNascimento());
	}
	
	public ApplicationContext getApplicationContext() {
        return context;
    }
 
    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }

}
