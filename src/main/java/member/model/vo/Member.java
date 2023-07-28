package member.model.vo;

import java.sql.Timestamp;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	private String gender;
	private String memberEmail;
	private String memberphone;
	private String memberAddress;
	private String memberhobby;
	private Timestamp memberdate;
	private Timestamp updatedate;
	private String YN;
	public Member(String memberId, String memberPw, String gender, String memberEmail, String memberphone,
			String memberAddress, String memberhobby) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.gender = gender;
		this.memberEmail = memberEmail;
		this.memberphone = memberphone;
		this.memberAddress = memberAddress;
		this.memberhobby = memberhobby;
	}
	public Member(String memberId, String memberPw, String memberEmail, String memberphone, String memberAddress,
			String memberhobby) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberEmail = memberEmail;
		this.memberphone = memberphone;
		this.memberAddress = memberAddress;
		this.memberhobby = memberhobby;
	}

	public Member() {
		
	}
	
	public Member(String memberId, String memberPw, String memberName, int memberAge, String gender, String email,
			String phone, String address, String hobby) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberAge = memberAge;
		this.gender = gender;
		this.memberEmail = email;
		this.memberphone = phone;
		this.memberAddress = address;
		this.memberhobby = hobby;
	}

	

	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return memberEmail;
	}
	public void setEmail(String email) {
		memberEmail = email;
	}
	public String getPhone() {
		return memberphone;
	}
	public void setPhone(String phone) {
		this.memberphone = phone;
	}
	public String getAddress() {
		return memberAddress;
	}
	public void setAddress(String address) {
		memberAddress = address;
	}
	public String getHobby() {
		return memberhobby;
	}
	public void setHobby(String hobby) {
		this.memberhobby = hobby;
	}
	public Timestamp getMemberdate() {
		return memberdate;
	}
	public void setMemberdate(Timestamp timestamp) {
		this.memberdate = timestamp;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp timestamp) {
		this.updatedate = timestamp;
	}
	public String getYN() {
		return YN;
	}
	public void setYN(String yN) {
		YN = yN;
	}
	@Override
	public String toString() {
		return "Member [아이디=" + memberId + ", 패스워드=" + memberPw + ", 이름=" + memberName + ", 나이="
				+ memberAge + ", 성별=" + gender + ", 이메일=" + memberEmail + ", 번호=" + memberphone + ", 주소=" + memberAddress
				+ ", 취미=" + memberhobby + ", 가입일=" + memberdate + ", 수정일자=" + updatedate + ", 회원여부=" + YN + "]";
	}
	
	
	
	
}
