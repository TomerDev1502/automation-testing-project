package models;

public class User {

	private String username="";
	private String firstName="";
	private String lastName="";
	private String password="";
	private String email="";
	private String address1="";
	private String address2="";
	private String country="";
	private String state="";
	private String city="";
	private String zip="";
	private String mobile="";
	private String title="";
	private boolean newsletter=false;
	private boolean specialOffers=false;
	private String company="";
	private String dayOfBirth="";
	private String monthOfBirth="";
	private String yearOfBirth="";

	//For Login
	public User (String email, String password) {
		this.email=email;
		this.password=password;
	}
	//For SignUp
	public User (String username, String email, String password) {
		this(email,password);
		this.username=username;
	}
	
	//Mandatory Fields Only
	public User(String username, String firstName, String lastName, String password, String email, String address1,
			String state, String city, String zip, String mobile) {

			this.username=username;
			this.email=email;
			this.password=password;
			this.firstName=firstName;
			this.lastName=lastName;
			this.address1=address1;
			this.state=state;
			this.city=city;
			this.zip=zip;
			this.mobile=mobile;
	}
	
	//Builder - ALL Fields
	public User(Builder builder) {
		this.username=builder.username;
		this.title=title;
		this.firstName=builder.firstName;
		this.lastName=builder.lastName;
		this.password=builder.password;
		this.email=builder.email;
		this.address1=builder.address1;
		this.address2=address2;
		this.country=country;
		this.state=builder.state;
		this.city=builder.city;
		this.zip=builder.zip;
		this.mobile=builder.mobile;
		this.newsletter=builder.newsletter;
		this.specialOffers=builder.specialOffers;
		this.company=builder.company;
		this.dayOfBirth=builder.dayOfBirth;
		this.monthOfBirth=builder.monthOfBirth;
		this.yearOfBirth=builder.yearOfBirth;
	}


	public static class Builder {

		private String username="";
		private String firstName="";
		private String lastName="";
		private String password="";
		private String email="";
		private String address1="";
		private String address2="";
		private String country="";
		private String state="";
		private String city="";
		private String zip="";
		private String mobile="";
		private String title="";
		private boolean newsletter=false;
		private boolean specialOffers=false;
		private String company="";
		private String dayOfBirth="";
		private String monthOfBirth="";
		private String yearOfBirth="";

		public Builder setUsername(String userName) {
			this.username = userName;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
		
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public Builder setAddress1(String address1) {
			this.address1 = address1;
			return this;
		}
		
		public Builder setAddress2(String address2) {
			this.address2 = address2;
			return this;
		}
		
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder setCountry(String country) {
			this.country = country;
			return this;
		}
		
		public Builder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public Builder setState(String state) {
			this.state = state;
			return this;
		}

		public Builder setZip(String zip) {
			this.zip = zip;
			return this;
		}
		
		public Builder setMobileNum(String mobile) {
			this.mobile = mobile;
			return this;
		}
		
	    public User build() {
	        return new User(this);
	    }
	}//end of Builder inner class
	
	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress1() {
		return address1;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getMobileNum() {
		return mobile;
	}

	public boolean isNewsletter() {
		return newsletter;
	}
	
	public boolean isSpecialOffers() {
		return specialOffers;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getDayOfBirth() {
		return dayOfBirth;
	}
	
	public String getMonthOfBirth() {
		return monthOfBirth;
	}
	
	public String getYearOfBirth() {
		return yearOfBirth;
	}

	
	@Override
	public String toString() {

		return "I am a user.";
	}
	
//	@Override
//	public String toString() {
//
//		return "{" + "\"name\": \""+getUsername()+"\","
//				+
//				"\"email\": \""+getEmail()+""\"," + "\"password\": \""+getPassword()+"\"," + "\"title\": \""+getTitle()+"\",";
//				+ "\"birth_date\": \"15\"," + "\"birth_month\": \"03\"," + "\"birth_year\": \"1990\","
//				+ "\"firstname\": \"FN\"," + "\"lastname\": \"LN\"," + "\"company\": \"CN\","
//				+ "\"address1\": \"Jer\"," + "\"address2\": \"Jer2\"," + "\"country\": \"India\","
//				+ "\"zipcode\": \"99999\"," + "\"state\": \"Gush\"," + "\"city\": \"Jerusalem\","
//				+ "\"mobile_number\": \"0501234567\"" + "}";
//	}

}
