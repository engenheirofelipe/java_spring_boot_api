package br.com.fiap.consumoapi.service;

public interface IConverteDados {
	// Create a pattern
	<T> T obterDados(String json, Class<T> classe);

}
