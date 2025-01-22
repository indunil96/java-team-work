package aiwa.entity;

public class Kanji {
	private int kanjiid;
	private String kanjiname;
	private String image;
	private String onyomi;
	private String kunyomi;
	private int strokecount;
	private String meaning;
	private String example;
	private Category category;

	public int getKanjiid() {
		return kanjiid;
	}

	public void setKanjiid(int kanjiid) {
		this.kanjiid = kanjiid;
	}

	public String getKanjiname() {
		return kanjiname;
	}

	public void setKanjiname(String kanjiname) {
		this.kanjiname = kanjiname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOnyomi() {
		return onyomi;
	}

	public void setOnyomi(String onyomi) {
		this.onyomi = onyomi;
	}

	public String getKunyomi() {
		return kunyomi;
	}

	public void setKunyomi(String kunyomi) {
		this.kunyomi = kunyomi;
	}

	public int getStrokecount() {
		return strokecount;
	}

	public void setStrokecount(int strokecount) {
		this.strokecount = strokecount;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
