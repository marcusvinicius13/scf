package br.com.scf.pessoa.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.scf.pessoa.pojo.PessoaFisica;
import br.com.scf.util.JPAUtil;

public class PopulaBanco {
	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		PessoaFisica pessoa = new PessoaFisica("Marcus Vinicius", "02914129122");
		em.persist(pessoa);

		em.getTransaction().commit();
		em.close();

	}

//	private static Autor geraAutor(String nome) {
//		Autor autor = new Autor();
//		autor.setNome(nome);
//		return autor;
//	}

//	private static Livro geraLivro(String isbn, String titulo, String data,
//			double preco, Autor autor) {
//		Livro livro = new Livro();
//		livro.setIsbn(isbn);
//		livro.setTitulo(titulo);
//		livro.setDtLancamento(data);
//		livro.setValor(preco);
//		livro.adicionaAutor(autor);
//		return livro;
//	}

	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}