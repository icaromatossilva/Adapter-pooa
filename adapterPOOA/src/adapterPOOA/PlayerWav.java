package adapterPOOA;

public class PlayerWav {
	
	public void tocarWav(String arquivo) {
		if(arquivo.equalsIgnoreCase(".wav") || arquivo.equalsIgnoreCase("wav")) {
			System.out.println("Sucesso: Reproduzindo musica em formato WAV");
		}else {
			System.out.println("O arquivo "+arquivo +" não é suportado. Este player roda apenas WAV.");
		}
	}

}
