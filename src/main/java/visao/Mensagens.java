package visao;

/* A classe Mensagens estende Exception para criar uma exceção personalizada
Fornece uma exceção específica que pode ser lançada e capturada para sinalizar condições de erro ou anomalias específicas na aplicação.
Facilita a identificação e o tratamento de erros específicos, melhorando a clareza e a manutenção do código.*/
public class Mensagens extends Exception{

    Mensagens(String msg) {
        super(msg);
    }
}
