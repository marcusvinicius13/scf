package br.com.scf.global;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Mensagem {

	/**
	 * Registro Incluído com Sucesso!.
	 */
	public static void mensagemSalvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Incluido", "Registro incluído com sucesso!"));
	}
	
	/**
	 * Registro já existente!
	 */
	public static void mensagemCargoJaCadastrado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Registro já cadastrado!"));
	}
	
	/**
	 * Falha na Importação!
	 */
	public static void mensagemFalhaImportação() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Falha ao importar os dados dos politicos!"));
	}
	
	
	/**
	 * Falha no Cadastro!
	 */
	public static void mensagemFalhaCadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Falha ao incluir o registro, tente novamente!"));
	}


	/**
	 * Registro excluído com sucesso!
	 */
	public static void mensagemExcluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Exclusão", "Registro excluído com sucesso!"));
	}

	/**
	 * Falha na Exclusão!
	 */
	public static void mensagemFalhaExcluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Falha ao excluir o registro, tente novamente!"));
	}

	/**
	 * Registro alterado com sucesso!
	 */
	public static void mensagemAlterar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Alteração", "Registro alterado com sucesso!"));
	}

	/**
	 * Registro alterado com sucesso!
	 */
	public static void mensagemDataInvalida() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Data inválida, digite uma data válida!"));
	}

	/**
	 * Logon de rede capturado.
	 */
	public static void mensagemCapturaLogon() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Logon de rede capturado."));
	}

	/**
	 * Usuário já existe. Escolha outro login ou altere o Domínio.
	 */
	public static void mensagemUsuarioExistente() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Usuário já existe. Escolha outro login ou altere o Domínio."));
	}

	/**
	 * Grupos associados com sucesso!
	 */
	public static void mensagemAssociacaoGrupo() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Grupos associados com sucesso!"));
	}

	/**
	 * Senha revalidada por mais 90 dias.
	 */
	public static void mensagemRevalidacaoSenha() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Atualizado", "Senha revalidada por mais 90 dias."));
	}

	/**
	 * Para efetuar a exclusão do usuário selecionado desmarque o grupo(s) aos
	 * quais ele esta associado.
	 */
	public static void mensagemProibicaoExclusao() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Aviso", "Para efetuar a exclusão do usuário selecionado desmarque o grupo(s) aos quais ele esta associado."));
	}

	/**
	 * Registro não excluído. Verifique se há associações.
	 */
	public static void mensagemVerificarDependencias() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Erro", "Registro não excluído. Verifique se há associações."));
	}

	/**
	 * Registro já existe na base de dados!
	 */
	public static void mensagemDuplicado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Registro existente", "Registro já cadastrado."));
	}
	
	public static void mensagemVinculoMesmoRegistro() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Registro Inconcistente", "Não pode vincular um registro a ele mesmo."));
	}

	/**
	 * Código da estrutura já existe!
	 */
	public static void mensagemCodEstrutura() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Registro existente", "Código da estrutura já existe!"));
	}

	/**
	 * Estrutura Superior inválida.
	 */
	public static void mensagemEstruturaSuperiorInvalida() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Registro Não vinculado", "Estrutura Superior inválida."));
	}

	/**
	 * Vínculo de nome duplicado!
	 */
	public static void mensagemNomeJaVinculado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Nome existente", "Vínculo de nome duplicado!"));
	}
	
	/**
	 * Vínculo de nome não vinculado!
	 */
	public static void mensagemNomeNaoVinculado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("O Nome não foi selecioinado!", "Favor selecionar um nome no resultado da consulta de nomes!"));
	}

	/**
	 * Vínculo de função duplicado!
	 */
	public static void mensagemFuncaoJaVinculado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Nome existente", "Vínculo de função duplicado!"));
	}

	/**
	 * Vínculo de comissão duplicado!
	 */
	public static void mensagemComissaoJaVinculado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Nome existente", "Vínculo de comissão duplicado!"));
	}

	/**
	 * Selecione algum Campo para gerar o relatório!
	 */
	public static void mensagemMarqueCampo() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Nenhum Campo selecionado", "Selecione algum campo para gerar o relatório!"));
	}

	/**
	 * Erro de validação CNPJ Inválido
	 * 
	 * @return
	 */
	public static FacesMessage mensagemCNPJInvalido() {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", "CNPJ Inválido");
	}

	/**
	 * Erro de validação Data Inválido
	 * 
	 * @return
	 */
	public static FacesMessage mensagemDataMaior() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", "Data final não pode ser anterior a data inicial!"));
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", "Data final não pode ser anterior a data inicial!");
	}

	/**
	 * Foto excluída com sucesso.
	 */
	public static void mensagemExclusaoFoto() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", "Foto excluída com sucesso."));
	}

	/**
	 * Indexação selecionada já cadastrada!
	 */
	public static void mensagemIndexacaoDuplicada() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Indexação selecionada já cadastrada!"));
	}

	/**
	 * Falha ao cadastrar informe corretamente o registro!
	 */
	public static void mensagemRegBranco() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", "Não e possivel cadastrar branco."));
	}

	/**
	 * Político já está com o Voto confirmado!
	 */
	public static void mensagemVotoDuplicado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Politico já está com o Voto confirmado!"));
	}

	/**
	 * Erro ao capturar dados do político.
	 */
	public static void mensagemVotoNaoRegistrado() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Voto não confirmado", "Verifique o cadastro do Político!"));
	}

	/**
	 * Copiado para área de transferência.
	 */
	public static void mensagemCopiadoAreaTrasferencia() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", "Copiado para área de transfêrencia."));
	}

	/**
	 * Código malicioso encontrado!<br />
	 * Transação abortada.
	 */
	public static void mensagemCodigoMalicioso(boolean keepMessage) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Código malicioso encontrado! Transação abortada."));
		if (keepMessage)
			context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
	/**
	 * Senha atual não confere.
	 */
	public static void mensagemSenhaInvalida() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Senha atual não confere."));
	}
	
	/**
	 * Senha atualizada com sucesso.
	 */
	public static void mensagemSenhaAtualizada() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", "Senha atualizada com sucesso."));
	}
	
	public static void mensagemDinamica(String mensagem, String sumario, Severity severidade, boolean keepMessage) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(severidade, sumario, mensagem));
		if (keepMessage)
			context.getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public static void mensagemFalhaExibir() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Falha na visualização do arquivo."));
	}
	
	/**
	 * Registro Falha de inclusão.
	 */
	public static void mensagemBuscarProposicao() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proposição inconcistentes ", "Favor incluir uma proposição válida!"));
	}
	
	public static void mensagemProposicaoExistente() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Proposição Existente ", "Proposição já existente na base de dados."));
	}
	
	public static void mensagemProposicaoNaoExistente() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proposição Não Existente", "Proposição não existente na base de dados."));
	}
	
	public static void mensagemEnviarEmail() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("", "Email enviado com sucesso."));
	}
	
	public static void mensagemFalhaDestinatarioEnviarEmail() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail sem destinatário", "Falha ao enviar, e-mail sem destinatário."));
	}
	
	public static void mensagemFalhaEnviarEmail() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha enviar e-mail", "Falha ao enviar e-mail inválido., verifique o registro."));
	}
}