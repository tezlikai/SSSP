package com.atguigu.sssp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.atguigu.sssp.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	/**
	 * 使用二级缓存，需要相应的JAR和对应的配置文件
	 * 还必须配置@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	 * @return
	 */
	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM Department d")
	List<Department> getAll();
	
}
