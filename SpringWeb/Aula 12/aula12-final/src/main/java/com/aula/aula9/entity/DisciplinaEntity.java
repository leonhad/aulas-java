package com.aula.aula9.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class DisciplinaEntity {
    @Id
    @Column(name = "id_disciplina")
    private Integer id;

    @Column(name = "nm_disciplina")
    private String nome;

    @Column(name = "nr_carga_horaria")
    private BigDecimal cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    private CursoEntity curso;

    @ManyToMany(mappedBy = "disciplinas")
    private List<AlunoEntity> alunos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer idDisciplina) {
        this.id = idDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nmDisciplina) {
        this.nome = nmDisciplina;
    }

    public BigDecimal getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(BigDecimal nrCargaHoraria) {
        this.cargaHoraria = nrCargaHoraria;
    }

    public List<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoEntity> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisciplinaEntity that = (DisciplinaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (cargaHoraria != null ? !cargaHoraria.equals(that.cargaHoraria) : that.cargaHoraria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cargaHoraria != null ? cargaHoraria.hashCode() : 0);
        return result;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity cursoByIdCurso) {
        this.curso = cursoByIdCurso;
    }
}
