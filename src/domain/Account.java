package domain;

public class Account {
	private Integer id;
	private String name;
	private Integer age;
	private String email;
	private Integer fno;
	private String reserve;
	private Integer reserveId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getFno() {
		return fno;
	}

	public void setFno(Integer fno) {
		this.fno = fno;
	}

	public String getReserve() {
		return reserve;
	};

	public void setReserve(String reserve) {
		this.reserve = reserve;
	}

	public Integer getReserveId() {
		return reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

}
