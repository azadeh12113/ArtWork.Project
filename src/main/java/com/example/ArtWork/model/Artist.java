package com.example.ArtWork.model;

import jakarta.persistence.*;

@Entity
public class Artist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String artName;
    
    @Column(nullable = false)
    private Integer score;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "judge_id", nullable = false)
    private Judge judge;
    
    public Artist() {}
    
    public Artist(String name, String artName, Integer score, Judge judge) {
        this.name = name;
        this.artName = artName;
        this.score = score;
        this.judge = judge;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getArtName() { return artName; }
    public void setArtName(String artName) { this.artName = artName; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public Judge getJudge() { return judge; }
    public void setJudge(Judge judge) { this.judge = judge; }

    @Override
    public String toString() {
        return "Artist [id=" + id + ", name=" + name + ", artName=" + artName + ", score=" + score + ", judge=" + judge + "]";
    }
}
