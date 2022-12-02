package com.example.dao;

import com.example.model.PostModel;
import com.mysql.cj.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAO {
    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }

    final String TableName = "Post";
    private final String BOARD_INSERT = "insert into Post (title, writer, content, rate) values (?,?,?,?)";
    private final String BOARD_UPDATE = "update Post set title=?, writer=?, content=?, rate=? where id=?";
    private final String BOARD_DELETE = "delete from Post  where id=?";
    private final String BOARD_GET = "select * from Post where id=?";
    private final String BOARD_LIST = "select * from Post order by id desc";

    public int insertBoard(PostModel model) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        try {
            return template.update(BOARD_INSERT, new Object[]{model.getTitle(), model.getWriter(), model.getContent(), model.getRate()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 글 삭제
    public int deleteBoard(int id) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            return template.update(BOARD_DELETE, new Object[]{id});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int updateBoard(PostModel model) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            return template.update(BOARD_UPDATE, new Object[]{model.getTitle(), model.getWriter(), model.getContent(), model.getRate(), model.getId()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public PostModel getBoard(int id) {
        PostModel model = new PostModel();
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        try {
            return template.queryForObject(BOARD_GET, new Object[]{id}, new BeanPropertyRowMapper<PostModel>(PostModel.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public List<PostModel> getBoardList(){
        List<PostModel> list = new ArrayList<PostModel>();
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        return template.query(BOARD_LIST, new PostRowMapper());
    }
}

class PostRowMapper implements RowMapper<PostModel>{

    @Override
    public PostModel mapRow(ResultSet rs, int i) throws SQLException {
        PostModel postModel = new PostModel(rs);
        return postModel;
    }
}
