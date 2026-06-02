package adapterPOOA;

public class PlayerMP4 {
	
	public void tocarMusicaMP4(String arquivo) {
		if(arquivo.equalsIgnoreCase(".mp4") || arquivo.equalsIgnoreCase("mp4")) {
			System.out.println("Sucesso: Reproduzindo musica em formato MP4");
		}else {
			System.out.println("O arquivo "+arquivo +" não é suportado. Este player roda apenas MP4.");
		}
	}

}
