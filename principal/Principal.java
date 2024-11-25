package br.com.fiap.consumo_api.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.consumo_api.model.DadosEpisodio;
import br.com.fiap.consumo_api.model.DadosSerie;
import br.com.fiap.consumo_api.model.DadosTemporada;
import br.com.fiap.consumo_api.service.ConsumoApi;
import br.com.fiap.consumo_api.service.ConverteDados;

public class Principal {
	
	Scanner leitura = new Scanner(System.in);
	
	private ConsumoApi consumo = new ConsumoApi();
	
	ConverteDados conversor = new ConverteDados();
	
	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	
	private final String APIKEY = "&apikey=6585022c";
	
	public void exibeMenu() {
		
		System.out.println("Digite o nome da série");
		
		var nomeSerie = leitura.nextLine();
		
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY);
		
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		
		System.out.println(dados);
		
		List<DadosTemporada> temporadas = new ArrayList<>();
		
		for (int i = 1; i<=dados.totalTemporadas(); i++) {
			json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + APIKEY + "&season=" + i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);
		
		for(int i = 0; i< dados.totalTemporadas(); i++) {
			List<DadosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
			for(int j = 0; j < episodiosTemporada.size(); j++) {
				System.out.println(episodiosTemporada.get(j).titulo());
			}
		}
		
//		temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
		
	}


}
