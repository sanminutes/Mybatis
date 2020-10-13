package dao;

import java.util.List;

import model.Team;

public interface TeamDao {
	List<Team> getTeamList() throws Exception;
}
