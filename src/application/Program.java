package application;

import java.util.Date;
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

		System.out.println("===== TEST 5: FIND ALL DEPARTMENTS =====");
		List<Department> departmentList = departmentDao.findAll();
		System.out.println();
		for(Department eachDepartment : departmentList) {
			System.out.println(eachDepartment);
		}
		System.out.println();
		
		System.out.println("===== TEST 6: SELLER INSERT =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println();
		System.out.println(newSeller.getId());
		System.out.println();

		System.out.println("===== TEST 7: DEPARTMENT INSERT =====");
		Department newDepartment = new Department(null, "Finanças");
		departmentDao.insert(newDepartment);
		System.out.println();
		System.out.println(newDepartment.getId());
		System.out.println();
		
		System.out.println("===== TEST 8: SELLER UPDATE =====");
		System.out.println();
		seller = sellerDao.findById(1);
		seller.setName("Martha");
		sellerDao.update(seller);
		System.out.println("Seller update completed");
		System.out.println();

		System.out.println("===== TEST 7: DEPARTMENT UPDATE =====");
		System.out.println();
		department = departmentDao.findById(1);
		department.setName("Mobílias");
		departmentDao.update(department);
		System.out.println("Department update completed");
		System.out.println();
	}

}
