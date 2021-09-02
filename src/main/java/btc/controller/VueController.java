package btc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import btc.dto.AxiosBoardDto;

@Controller
public class VueController {
	@RequestMapping("/index")
	public String index() throws Exception {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosget1", method=RequestMethod.GET)
	public void axiosGet1(@RequestParam("getValue1") String getValue1, @RequestParam("getValue2") String getValue2, @RequestParam("getValue3") String getValue3) throws Exception {
		System.out.println("get 통신, @RequestParam 사용");
		System.out.println("getValue1 : " + getValue1 + "\ngetValue2 : " + getValue2 + "\ngetValue3 : " + getValue3);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosget2", method=RequestMethod.GET)
	public void axiosGet2(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("get 통신, Map 타입 사용");
		System.out.println(map.get("getValue1") + "\n" + map.get("getValue2") + "\n" + map.get("getValue3"));
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosget3", method=RequestMethod.GET)
	public void axiosGet3(AxiosBoardDto board) throws Exception {
		System.out.println("get 통신, Dto 타입 사용");
		System.out.println(board);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosget4", method=RequestMethod.GET)
	public void axiosGet4() throws Exception {
		System.out.println("get 통신, Dto 타입 사용");
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiospost1", method=RequestMethod.POST)
	public void axiosPost1(
			@RequestParam("getValue1") int getValue1,
			@RequestParam("getValue2") String getValue2,
			@RequestParam("getValue3") String getValue3
			) throws Exception {
		System.out.println("post 통신, @RequestParam 사용");
		System.out.println("getValue1 : " + getValue1 + "\ngetValue2 : " + getValue2 + "\ngetValue3 : " + getValue3);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiospost2", method=RequestMethod.POST)
	public void axiosPost2(@RequestBody Map<String, String> map) throws Exception {
		System.out.println("post 통신, Map 사용");
		System.out.println(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiospost3", method=RequestMethod.POST)
	public void axiosPost3(@RequestBody AxiosBoardDto board) throws Exception {
		System.out.println("post 통신, dto 사용");
		System.out.println(board);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiospost4", method=RequestMethod.POST)
	public void axiosPost4() throws Exception {
		System.out.println("post 통신, 매개변수 없음");
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosput1", method=RequestMethod.PUT)
	public void axiosPut1(@RequestParam("getValue1") int getValue1, @RequestParam("getValue2") String getValue2, @RequestParam("getValue3") String getValue3) throws Exception {
		System.out.println("put 통신, @RequestParam 사용");
		System.out.println("getValue1 : " + getValue1 + "\ngetValue2 : " + getValue2 + "\ngetValue3 : " + getValue3);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosput2", method=RequestMethod.PUT)
	public void axiosPut2(@RequestBody Map<String, String> map) throws Exception {
		System.out.println("put 통신, Map 사용");
		System.out.println(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosput3", method=RequestMethod.PUT)
	public void axiosPut3(AxiosBoardDto board) throws Exception {
		System.out.println("put 통신, dto 사용");
		System.out.println(board);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosput4", method=RequestMethod.PUT)
	public void axiosPut4() throws Exception {
		System.out.println("put 통신, 매개변수 없음");
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosdelete1", method=RequestMethod.DELETE)
	public void axiosDelete1(@RequestParam("getValue1") int getValue1, @RequestParam("getValue2") String getValue2, @RequestParam("getValue3") String getValue3) throws Exception {
		System.out.println("delete 통신, @RequestParam 사용");
		System.out.println("getValue1 : " + getValue1 + "\ngetValue2 : " + getValue2 + "\ngetValue3 : " + getValue3);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosdelete2", method=RequestMethod.DELETE)
	public void axiosDelete2(Map<String, String> map) throws Exception {
		System.out.println("delete 통신, Map 사용");
		System.out.println(map);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosdelete3", method=RequestMethod.DELETE)
	public void axiosDelete3(AxiosBoardDto board) throws Exception {
		System.out.println("delete 통신, dto 사용");
		System.out.println(board);
	}
	
	@ResponseBody
	@RequestMapping(value="/test/axiosdelete4", method=RequestMethod.DELETE)
	public void axiosDelete4() throws Exception {
		System.out.println("delete 통신, 매개변수 없음");
	}
}










