package day16_JSONArray;

import org.junit.Test;

import com.iphone567.user.domain.Result;
import com.iphone567.user.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MyTest {

	private User user = new User(10086, "biweiming", "password", 12, "tvlogin@qq.com", "male", "china", false);
	Result<User> result = new Result<User>(0, "登陆成功", user);

	@Test
	public void testJSONArray() {
		String jsonString = JSONArray.fromObject(result).toString();
		System.out.println(jsonString);
	}

	@Test
	public void testJSONObject() {
		String jsonString = JSONObject.fromObject(result).toString();
		System.out.println(jsonString);
	}
}
