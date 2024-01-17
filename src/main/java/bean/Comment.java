package bean;

public class Comment {
	private int idComment;
	private int idUser;
	private String question;
	private int idProduct;
	private String timeQuestion;
	private String answer;
	private String timeAnswer;
	private int rate;
	private String nameComment;

	public String getNameComment() {
		return nameComment;
	}

	public void setNameComment(String nameComment) {
		this.nameComment = nameComment;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getTimeQuestion() {
		return timeQuestion;
	}

	public void setTimeQuestion(String timeQuestion) {
		this.timeQuestion = timeQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTimeAnswer() {
		return timeAnswer;
	}

	public void setTimeAnswer(String timeAnswer) {
		this.timeAnswer = timeAnswer;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", idUser=" + idUser + ", question=" + question + ", idProduct="
				+ idProduct + ", timeQuestion=" + timeQuestion + ", answer=" + answer + ", timeAnswer=" + timeAnswer
				+ ", rate=" + rate + ", nameComment=" + nameComment + "]";
	}

}
