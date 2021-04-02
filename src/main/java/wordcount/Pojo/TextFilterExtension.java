package wordcount.Pojo;

public class TextFilterExtension {

	public static String FilterText(String text) {
		text = text.replace(". ", " ");
		//text = text.replace("-", " ");
		text = text.replace(".", "");
		return text;
	}
}
