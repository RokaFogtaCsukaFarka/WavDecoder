package WavDecoder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

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
	
	WavData(String fileName) throws FileNotFoundException, Exception {
		try {
			RandomAccessFile raf = new RandomAccessFile(fileName, "r");
			FileChannel channel = raf.getChannel();
			MappedByteBuffer map;
			CharBuffer charBuffer;
			Long fileLength = raf.length();
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,0, 4);
			map.order(ByteOrder.BIG_ENDIAN);
			charBuffer = map.asCharBuffer();
			if(charBuffer.hasArray())
				chunkId = new String(charBuffer.array());
			else {
				raf.close();
				throw(new Exception("Has not the array!"));
			}
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,4, 4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			chunkSize = Integer.parseInt(new String(charBuffer.array()));
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,8, 4);
			map.order(ByteOrder.BIG_ENDIAN);
			charBuffer = map.asCharBuffer();
			format = new String(charBuffer.array());
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,12, 4);
			map.order(ByteOrder.BIG_ENDIAN);
			charBuffer = map.asCharBuffer();
			subchunk1Id = new String(charBuffer.array());
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,16, 4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			subchunk1Size = Integer.parseInt(new String(charBuffer.array()));
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,20, 2);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			audioFormat = new String(charBuffer.array());
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,22, 4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			numChannels = Integer.parseInt(new String(charBuffer.array()));
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,24, 4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			sampleRate = Integer.parseInt(new String(charBuffer.array()));			
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,28,4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			byteRate = Integer.parseInt(new String(charBuffer.array()));			
			
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,32, 2);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			blockAlign = Integer.parseInt(new String(charBuffer.array()));		
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,34, 2);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			bitsPerSample = Integer.parseInt(new String(charBuffer.array()));
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,36, 4);
			map.order(ByteOrder.BIG_ENDIAN);
			charBuffer = map.asCharBuffer();
			subchunk2Id = new String(charBuffer.array());
			
			map = channel.map(FileChannel.MapMode.READ_ONLY,40, 4);
			map.order(ByteOrder.LITTLE_ENDIAN);
			charBuffer = map.asCharBuffer();
			subchunk2Size = Integer.parseInt(new String(charBuffer.array()));
			
			
			Long available = fileLength - 40;
			
			while(available > 0) {
				map = channel.map(FileChannel.MapMode.READ_ONLY,fileLength - available,16);
				map.order(ByteOrder.LITTLE_ENDIAN);
				charBuffer = map.asCharBuffer();
				data += new String(charBuffer.array());
				
				available -= 4;
			}
			
			raf.close();
		} catch(UnsupportedOperationException e) {
			System.out.print(e.toString());
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
