package WavDecoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WavData {
	private String chunkId;
	private Integer chunkSize;
	private String format;
	private String subchunk1Id;
	private Integer subchunk1Size;
	private String audioFormat;
	private Integer numChannels;
	private Integer sampleRate;
	private Integer byteRate;
	private Integer blockAlign;
	private Integer bitsPerSample;
	private String subchunk2Id;
	private Integer subchunk2Size;
	private String data;
	
	WavData(String fileName) throws FileNotFoundException{
		try {
			FileInputStream reader = new FileInputStream(fileName);
			byte[] buffer = new byte[16];
		
			reader.read(buffer, 0, 4);
			chunkId = new String(buffer, StandardCharsets.UTF_8);
			
			reader.read(buffer,4,4);
			chunkSize = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,8,4);
			format = new String(buffer, StandardCharsets.UTF_8);
			
			reader.read(buffer,12,4);
			subchunk1Id = new String(buffer, StandardCharsets.UTF_8);
			
			reader.read(buffer,16,4);
			subchunk1Size = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,20,2);
			audioFormat = new String(buffer, StandardCharsets.UTF_8);
			
			reader.read(buffer,22,2);
			numChannels = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,24,4);
			sampleRate = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,28,4);
			byteRate = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,32,2);
			blockAlign = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,34,2);
			bitsPerSample = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			reader.read(buffer,36,4);
			subchunk2Id = new String(buffer, StandardCharsets.UTF_8);
			
			reader.read(buffer,40,4);
			subchunk2Size = Integer.getInteger(new String(buffer, StandardCharsets.UTF_8));
			
			Integer available = reader.available();
			while(available > 15) {
				reader.read(buffer,chunkSize- available,16);
				data += new String(buffer, StandardCharsets.UTF_8);
				
				available = reader.available();
			}
		} catch(IOException exception) {
			System.out.println(exception.toString() + "/nTry again!");
		} finally {
			System.out.println(data);
		}
	}
	
	public String getChunkId() {
		return chunkId;
	}
	public void setChunkId(String chunkId) {
		this.chunkId = chunkId;
	}
	public Integer getChunkSize() {
		return chunkSize;
	}
	public void setChunkSize(Integer chunkSize) {
		this.chunkSize = chunkSize;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getSubchunk1Id() {
		return subchunk1Id;
	}
	public void setSubchunk1Id(String subchunk1Id) {
		this.subchunk1Id = subchunk1Id;
	}
	public Integer getSubchunk1Size() {
		return subchunk1Size;
	}
	public void setSubchunk1Size(Integer subchunk1Size) {
		this.subchunk1Size = subchunk1Size;
	}
	public String getAudioFormat() {
		return audioFormat;
	}
	public void setAudioFormat(String audioFormat) {
		this.audioFormat = audioFormat;
	}
	public Integer getNumChannels() {
		return numChannels;
	}
	public void setNumChannels(Integer numChannels) {
		this.numChannels = numChannels;
	}
	public Integer getSampleRate() {
		return sampleRate;
	}
	public void setSampleRate(Integer sampleRate) {
		this.sampleRate = sampleRate;
	}
	public Integer getByteRate() {
		return byteRate;
	}
	public void setByteRate(Integer byteRate) {
		this.byteRate = byteRate;
	}
	public Integer getBlockAlign() {
		return blockAlign;
	}
	public void setBlockAlign(Integer blockAlign) {
		this.blockAlign = blockAlign;
	}
	public Integer getBitsPerSample() {
		return bitsPerSample;
	}
	public void setBitsPerSample(Integer bitsPerSample) {
		this.bitsPerSample = bitsPerSample;
	}
	public String getSubchunk2Id() {
		return subchunk2Id;
	}
	public void setSubchunk2Id(String subchunk2Id) {
		this.subchunk2Id = subchunk2Id;
	}
	public Integer getSubchunk2Size() {
		return subchunk2Size;
	}
	public void setSubchunk2Size(Integer subchunk2Size) {
		this.subchunk2Size = subchunk2Size;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
