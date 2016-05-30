package br.ufc.quixada.npi.sinutri.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import br.ufc.quixada.npi.sinutri.model.Papel;
import br.ufc.quixada.npi.sinutri.model.Servidor;
import br.ufc.quixada.npi.sinutri.repository.PapelRepository;
import br.ufc.quixada.npi.sinutri.repository.ServidorRepository;
import br.ufc.quixada.npi.sinutri.service.PessoaService;

@Named
public class PessoaServiceImpl implements PessoaService {

	@Inject
	private PapelRepository papelRepository;
	
	@Inject
	private ServidorRepository servidorRepository;
	
	@Inject
	private UsuarioService usuarioService;

	@Override
	public Papel buscaPapelPorNome(String papel) {
		return papelRepository.findByNome(papel);
	}

	@Override
	public Servidor buscarServidorPorCpf(String cpf) {

		Servidor servidor = servidorRepository.findByCpf(cpf);
		Usuario usuario = usuarioService.getByCpf(servidor.getPessoa().getCpf());
		servidor.getPessoa().setNome(usuario.getNome());
		servidor.getPessoa().setEmail(usuario.getEmail());
		servidor.getPessoa().setTelefone(usuario.getTelefone());
		servidor.getPessoa().setDataNascimento(usuario.getNascimento());

		return servidorRepository.findByCpf(cpf);
	}
	
}
