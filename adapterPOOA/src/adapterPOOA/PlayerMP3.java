package adapterPOOA;

public class PlayerMP3 implements MediaPlayer{
	
	@Override
	public void tocarMusica(String arquivo) {
		
		if(arquivo.equalsIgnoreCase(".mp3")|| arquivo.equalsIgnoreCase("mp3")) {
			System.out.println("Sucesso: Reproduzindo musica em formato MP3");
		}else {
			System.out.println("O arquivo "+arquivo +" não é suportado. Este player roda apenas MP3.");
		}
	}

}
