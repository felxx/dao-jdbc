package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department department = departmentDao.findById(1);
		Seller seller = sellerDao.findById(2);
		
		System.out.println("=== TEST 1: FIND DEPARTMENT BY ID ===");
		System.out.println();
		System.out.println(department);
		System.out.println();
		
		System.out.println("===== TEST 2: FIND SELLER BY ID =====");
		System.out.println();
		System.out.println(seller);
		System.out.println();
		
		System.out.println("===== TEST 3: FIND SELLERS BY DEPARTMENT =====");
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		System.out.println();
		for(Seller eachSeller : sellerList) {
			System.out.println(eachSeller);
		}
		System.out.println();

		System.out.println("===== TEST 4: FIND ALL SELLERS =====");
		List<Seller> sellerListAll = sellerDao.findAll();
		System.out.println();
		for(Seller eachSeller : sellerListAll) {
			System.out.println(eachSeller);
		}
		System.out.println();
	}

}
