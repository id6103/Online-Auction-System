package auction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import auction.vo.LoginUserVO;
import auction.vo.ProductVO;
import auction.vo.RecordVO;
import auction.vo.RegisterVO;

public class UserDAO extends DAOBase {
	public boolean login(LoginUserVO vo) {
		boolean flag = false;
		String sql = "select pwd from user where username = ?";
		Connection conn = null;
		try {
			conn = getConn();
			// ����ִ�д��ʺŵ�SQL��������---��������
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getUsr());
			ResultSet rs = ps.executeQuery();
			// �ж��Ƿ�����һ�м�¼������У�������һ��,����true
			// ���û����һ�У�����ǰ�����һ�У�����false
			if (rs.next()) {// ��ǰ��
				String pwd = rs.getString("pwd");
				if (pwd.equals(vo.getPwd()))
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �����Ƿ����쳣���˴�����ִ��
			this.close(conn);
		}
		// return flag;
		// �˴���Ҫ�޸�
		return flag;
	}

	// ��product������ȡ����������������Ʒ��Ϣ
	public List<ProductVO> isOnSale() {
		List<ProductVO> arr = new ArrayList<ProductVO>();
		String sql = "select * from product where state=1";
		Connection conn = null;
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// ��ǰ��
				int productId = rs.getInt("id");
				String productName = rs.getString("productname");
				String productDesc = rs.getString("productdesc");
				ProductVO vo = new ProductVO(productId, productName,
						productDesc);
				arr.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return arr;
	}

	// �鿴����Ʒ��ϸ��Ϣ
	public ProductVO queryByProductId(int productId) {
		String sql = "select * from product where id=" + productId;
		Connection conn = null;
		ProductVO vo = null;
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {// ��ǰ��
				String productName = rs.getString("productname");
				String productDesc = rs.getString("productdesc");
				String startTime = rs.getString("starttime");
				String endTime = rs.getString("endtime");
				String img = rs.getString("img");
				String saleName = rs.getString("salename");
				int startPrice = rs.getInt("startprice");
				int curPrice = rs.getInt("curprice");
				int state = rs.getInt("state");
				vo = new ProductVO(productId, productName, productDesc,
						startTime, endTime, img, saleName, startPrice,
						curPrice, state);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return vo;
	}

	// ���ݹؼ��ֲ�ѯ����Ʒ
	public List<ProductVO> queryByKeyword(String keyword, int page, int state) {
		List<ProductVO> arr = new ArrayList<ProductVO>();

		int startIndex = (page - 1) * 10;
		// String sql = "select * from product where productname like '%" +
		// keyword
		// + "%'   limit ?, 10";
		String sql = "select * from product where productname like '%"
				+ keyword + "%' and state=? limit ?, 10";
		Connection conn = null;

		try {
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, startIndex);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int productId = rs.getInt("id");
				String productName = rs.getString("productname");
				String productDesc = rs.getString("productdesc");

				ProductVO vo = new ProductVO(productId, productName,
						productDesc);
				arr.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return arr;
	}

	// �����û���ѯ����Ʒ���ҵ�������
	public List<ProductVO> queryBySaleName(String saleName) {
		List<ProductVO> arr = new ArrayList<ProductVO>();
		String sql = "select * from product where salename= ?";
		Connection conn = null;
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, saleName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// ��ǰ��
				int productId = rs.getInt("id");
				String productName = rs.getString("productname");
				String productDesc = rs.getString("productdesc");
				int state = rs.getInt("state");
				ProductVO vo = new ProductVO(productId, productName,
						productDesc, state);
				arr.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return arr;
	}

	// �����û���ѯ�Լ�����������Ʒ
	public List<ProductVO> queryByBuyName(String buyName) {
		List<ProductVO> arr = new ArrayList<ProductVO>();
		String sql = "select * from product where buyname= ? and state = 0";
		Connection conn = null;
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, buyName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// ��ǰ��
				int productId = rs.getInt("id");
				String productName = rs.getString("productname");
				String productDesc = rs.getString("productdesc");
				ProductVO vo = new ProductVO(productId, productName,
						productDesc);
				arr.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return arr;
	}

	// �����û���ѯ�Լ��ľ��ۼ�¼
	public List<RecordVO> queryMyProduct(String buyName) {
		List<RecordVO> arr = new ArrayList<RecordVO>();
		String sql = "select * from record where buyname=?";
		Connection conn = null;
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, buyName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// ��ǰ��

				int id = rs.getInt("id");
				int productId = rs.getInt("productid");
				String productName = rs.getString("productname");
				int price = rs.getInt("price");
				RecordVO vo = new RecordVO(id,productId, productName,buyName,price);
				arr.add(vo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return arr;
	}

	// �鿴�ɽ���¼
	public List<RecordVO> queryRecordByProductId(int productId) {
		String sql = "select * from record where productid=" + productId;
		Connection conn = null;
		List<RecordVO> arr = new ArrayList<RecordVO>();
		try {
			conn = getConn();
			java.sql.PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// ��ǰ��
				int id = rs.getInt("id");
				String buyName = rs.getString("buyname");
				int price = rs.getInt("price");
				String time=rs.getString("time");
				RecordVO vo = new RecordVO(id, productId, buyName, price,time);
				arr.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return arr;
	}

	// �����ѯ�����ҳ��
	public int totalPage(String keyword) {
		int totalPage = 0;
		int totalNum = 0;

		String sql = "select count(*) as total from product where productname like '%"
				+ keyword + "%' and state=1";
		Connection conn = null;

		try {
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				totalNum = rs.getInt("total");
			}

			if (totalNum % 10 != 0)
				totalPage = totalNum / 10 + 1;
			else
				totalPage = totalNum / 10;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(conn);
		}

		return totalPage;
	}

	// �Ƿ�ɹ�����
	public boolean submitPrice(int productId, String buyName, int myPrice,
			String productName) {
		// com.mysql.jdbc.Driver
		Connection conn = null;
		try {
			conn = getConn();
			// 3.��ȡִ��sql��������
			String sql = "insert into record (productid,buyname,price,productname,time)"
					+ "values (?, ?, ?,?,now())";
			PreparedStatement ps = conn.prepareStatement(sql);

			// 4.���ʺ��滻�ɾ������ֵ,��ſ�ʼ��1
			ps.setInt(1, productId);
			ps.setString(2, buyName);
			ps.setInt(3, myPrice);
			ps.setString(4, productName);

			// 5.ִ��sql���
			int count = ps.executeUpdate();// �˴��޲Σ�
			// count�������ݿ��м�����¼�ܵ���Ӱ��
			// System.out.println("count = " + count);
			if (count == 1)
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return false;
	}

	// ���㱾����������߳���
	public int maxPrice(int productId) {
		int max = 0;

		String sql = "select buyname,max(price) as max from record where productId=?";
		Connection conn = null;

		try {
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				max = rs.getInt("max");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(conn);
		}

		return max;
	}

	// ��������������ߵ���
	public String maxBuyer(int productId, int max) {

		String sql = "select buyname from record where productId=? and price=?";
		Connection conn = null;
		String buyName = null;

		try {
			conn = getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setInt(2, max);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				buyName = rs.getString("buyname");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(conn);
		}

		return buyName;
	}

	// ��������������߼ۺ���Һͽ���ʱ��������ݿ���
	public boolean endAuction(String buyName, int maxPrice, int productId) {
		boolean flag = false;
		String sql = "update product set buyname=?,curprice=?,state=0,endtime=now() where id=?";
		Connection conn = null;
		try {
			conn = getConn();
			// ����ִ�д��ʺŵ�SQL��������---��������
			PreparedStatement ps = conn.prepareStatement(sql);

			// 4.���ʺ��滻�ɾ������ֵ,��ſ�ʼ��1

			ps.setString(1, buyName);
			ps.setInt(2, maxPrice);
			ps.setInt(3, productId);

			// 5.ִ��sql���
			int count = ps.executeUpdate();// �˴��޲Σ�
			// count�������ݿ��м�����¼�ܵ���Ӱ��
			// System.out.println("count = " + count);

			if (count == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �����Ƿ����쳣���˴�����ִ��
			this.close(conn);
		}
		return flag;
	}

	// �����µ�����
	public boolean addAuction(ProductVO vo) {
		boolean flag = false;
		String sql = "insert into product(productname,productdesc,starttime,endtime,img,salename,startprice,state) values(?,?,now(),?,?,?,?,1)";
		Connection conn = null;
		try {
			conn = getConn();
			// ����ִ�д��ʺŵ�SQL��������---��������
			PreparedStatement ps = conn.prepareStatement(sql);

			// 4.���ʺ��滻�ɾ������ֵ,��ſ�ʼ��1

			ps.setString(1, vo.getProductName());
			ps.setString(2, vo.getProductDesc());
			ps.setString(3, "unknown");
			ps.setString(4, vo.getImg());
			ps.setString(5, vo.getSaleName());
			ps.setInt(6, vo.getStartPrice());

			// 5.ִ��sql���
			int count = ps.executeUpdate();// �˴��޲Σ�
			// count�������ݿ��м�����¼�ܵ���Ӱ��
			// System.out.println("count = " + count);

			if (count == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {// �����Ƿ����쳣���˴�����ִ��
			this.close(conn);
		}
		return flag;
	}
	
	//�ж��û����Ƿ��ظ�
	public boolean username(String name) {
		boolean success = true;
		Connection conn = getConn();
		try {
			String sql = 
				"select username from user";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				String name1 = rs.getString("username");
				if(name.equals(name1) )
					success = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return success;
		//return false;
	}
	
	//�����û���Ϣд�����ݿ�
	public boolean insert(RegisterVO vo) {
		Connection conn = null;
		boolean flag=false;
		try {
			//1. open connection
			conn = getConn();
			// 2.��ȡִ��sql��������
			String sql = "insert into user (username, pwd, address,identification_no,age,hobby)"
					+ "values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//3.���ʺ��滻�ɾ������ֵ,��ſ�ʼ��1

			ps.setString(1, vo.getUsername() );
			ps.setInt(2, vo.getPwd());
			ps.setString(3, vo.getAddress());
			ps.setInt(4, vo.getIdentification_no() );
			ps.setInt(5, vo.getAge());
			ps.setString(6, vo.getHobby() );
			//ps.setString(8, vo.getState());
			
			
			// 4.ִ��sql���
			int count = ps.executeUpdate();//�˴��޲Σ�
			// count�������ݿ��м�����¼�ܵ���Ӱ��
			//System.out.println("count = " + count);
			if(count == 1)
				flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return flag;
	}
	
	public boolean regist(RegisterVO vo) {
		
		boolean success = false;
		Connection conn = getConn();
		return success;
	}
	
	//�û���Ϣ�޸�
	public boolean update(RegisterVO vo){
		Connection conn=null;
		boolean flag=false;
		try {
			//1. open connection
			conn = getConn();
			// 2.��ȡִ��sql��������
			String sql = "update user set pwd=?,address=?,identification_no=?,age=?,hobby=? where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//3.���ʺ��滻�ɾ������ֵ,��ſ�ʼ��1
			ps.setInt(1, vo.getPwd());
			ps.setString(2, vo.getAddress());
			ps.setInt(3, vo.getIdentification_no() );
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getHobby() );
		    ps.setString(6, vo.getUsername());
			// 4.ִ��sql���
			int count = ps.executeUpdate();//�˴��޲Σ�
			// count�������ݿ��м�����¼�ܵ���Ӱ��
			//System.out.println("count = " + count);
			if(count == 1)
				flag=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return flag;
	}

}
