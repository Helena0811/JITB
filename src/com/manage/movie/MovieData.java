package com.manage.movie;
// 영화 저장 정보를 담기 위한 DTO 
public class MovieData {
	private MovieData instance;
	
	private int movie_id;
	private String poster;
	private String name;
	private String main_actor;
	private String director;
	private String story;
	private String start_date;
	private String end_date;
	private int run_time;	
	
	public MovieData getInstance() {
		return instance;
	}

	public void setInstance(MovieData instance) {
		this.instance = instance;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMain_actor() {
		return main_actor;
	}

	public void setMain_actor(String main_actor) {
		this.main_actor = main_actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}
	
}
