package co.jh.notice.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jh.notice.common.DataSource;
import co.jh.notice.service.NoticeMapper;
import co.jh.notice.service.NoticeService;
import co.jh.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

//	private DataSource dao=DataSource.getInstance();
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
	SqlSession sqlSession = DataSource.getInstance().openSession(true);// db연결
	NoticeMapper map = sqlSession.getMapper(NoticeMapper.class);// mapper설정(연결)

	@Override
	public List<NoticeVO> noticeSelectList() {
//		List<NoticeVO> notices=new ArrayList<>();
//		NoticeVO vo;
//		String sql="select * from notice";
//		
//		try {
//			conn=dao.getConnection();
//			pstmt=conn.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				vo=new NoticeVO();
//				vo.setNoticeHit(rs.getInt("notice_hit"));
//				vo.setNoticeId(rs.getInt("notice_id"));
//				//vo.setNoticeSubject(rs.getString("notice_subject"));
//				vo.setNoticeTitle(rs.getString("notice_title"));
//				vo.setNoticeWdate(rs.getDate("notice_wdate"));
//				vo.setNoticeWriter(rs.getString("notice_writer"));
//				notices.add(vo);
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close();
//		}
//		return notices;
		return map.noticeSelectList();
	}

//	private void close() {
//		try {
//			if(rs!=null) 	rs.close();
//			if(pstmt!=null)pstmt.close();
//			if(conn!=null)conn.close();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

}
