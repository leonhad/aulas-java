package com.aula.aula10.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso")
public class CursoEntity {

    @Id
    @Column(name = "id_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nm_curso", nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "curso")
    private List<DisciplinaEntity> disciplinas;

    public List<DisciplinaEntity> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaEntity> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idCurso) {
        this.id = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nmCurso) {
        this.nome = nmCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoEntity that = (CursoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
