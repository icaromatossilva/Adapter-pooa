package adapterPOOA;

public class MediaAdapter implements MediaPlayer {
	private PlayerMP4 mp4;
	private PlayerWav wav;
	
	@Override
	public void tocarMusica(String arquivo) {
		if(arquivo.equalsIgnoreCase(".mp4") || arquivo.equalsIgnoreCase("mp4")) {
			mp4 = new PlayerMP4();
			mp4.tocarMusicaMP4(arquivo);
		}else if(arquivo.equalsIgnoreCase(".wav") || arquivo.equalsIgnoreCase("wav")) {
			wav = new PlayerWav();
			wav.tocarWav(arquivo);
		}
	}

}
