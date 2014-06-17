package vn.cyber.nampack;

public class Comment {
 String text;
 String mail= "vanthi";
 String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Comment() {
	// TODO Auto-generated constructor stub
}

public Comment(String text, String mail) {
	super();
	this.text = text;
	this.mail = mail;
}


public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((text == null) ? 0 : text.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Comment other = (Comment) obj;
	if (text == null) {
		if (other.text != null)
			return false;
	} else if (!text.equals(other.text))
		return false;
	return true;
}
 
}
