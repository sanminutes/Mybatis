package model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CartDao;

//import crud.Crud;

@Service
public class Cart {
	@Autowired
	private CartDao cartDao;
	private LinkedList<String> codeList = new LinkedList<String>();
	private LinkedList<Integer> numList = new LinkedList<Integer>();
	private LinkedList<String> sizeList = new LinkedList<String>();
	private String id;

	public Cart() {

	}

	public Cart(String id) {
		this.id = id;
	}

	private void updateCart(String code, String sizee, int num, String id) {
		CartItem item = new CartItem();
		item.setCode(code);
		item.setSizee(sizee);
		item.setNum(num);
		item.setId(id);
		cartDao.updateCart(item);
	}

	public void addCart(String code, String size, int num, String id) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code) && sizeList.get(i).equals(size)) {
				numList.set(i, numList.get(i) + num);
				updateCart(code, size, numList.get(i), id);
				return;
			}
		}
		codeList.add(code);
		sizeList.add(size);
		numList.add(num);
		insertCart(code, size, num, id);
	}

	private void insertCart(String code, String sizee, int num, String id) {
		Integer seqno = cartDao.getMAxCartId();
		if (seqno == null)
			seqno = 1;
		else
			seqno = seqno + 1;
		CartItem item = new CartItem();
		item.setSeqno(seqno);
		item.setCode(code);
		item.setSizee(sizee);
		item.setNum(num);
		item.setId(id);
		cartDao.insertCart(item);
	}

	public void deleteItem(String code, String sizee, String id) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code) && sizeList.get(i).equals(sizee)) {
				codeList.remove(i);
				sizeList.remove(i);
				numList.remove(i);
				CartItem item = new CartItem();
				item.setId(id);
				item.setCode(code);
				item.setSizee(sizee);
				cartDao.deleteCart(item);
				return;
			}
		}
	}

	public void modifyItem(String code, String sizee, int num, String id) {
		for (int i = 0; i < codeList.size(); i++) {
			if (codeList.get(i).equals(code)) {
				numList.set(i, num);
				updateCart(code, sizee, num, id);
				return;
			}
		}
	}

	public void saveDB() {

		for (int i = 0; i < codeList.size(); i++) {
			String code = codeList.get(i);
			Integer num = numList.get(i);
			CartItem item = new CartItem();
			item.setId(id);
			item.setCode(code);
			item.setNum(num);

		}
	}

	public void setCodeList(int index, String code) {
		this.codeList.add(index, code);
	}

	public void setNumList(int index, Integer num) {
		this.numList.add(index, num);
	}

	public List<CartItem> getCart(String id) {
		return this.cartDao.selectCart(id);
	}

	public void deleteDB(String id) {

	}

	public LinkedList<String> getCodeList() {
		return codeList;
	}

	public LinkedList<Integer> getNumList() {
		return numList;
	}

	public String getId() {
		return id;
	}

}
