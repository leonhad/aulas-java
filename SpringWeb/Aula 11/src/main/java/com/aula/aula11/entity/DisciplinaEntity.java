package com.aula.aula11.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class DisciplinaEntity {
    @Id
    @Column(name = "id_disciplina")
    private Integer idDisciplina;

    @Column(name = "nm_disciplina")
    private String nmDisciplina;

    @Column(name = "nr_carga_horaria")
    private BigDecimal nrCargaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    private CursoEntity curso;

    @ManyToMany(mappedBy = "disciplinas")
    private List<AlunoEntity> alunos;

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNmDisciplina() {
        return nmDisciplina;
    }

    public void setNmDisciplina(String nmDisciplina) {
        this.nmDisciplina = nmDisciplina;
    }

    public BigDecimal getNrCargaHoraria() {
        return nrCargaHoraria;
    }

    public void setNrCargaHoraria(BigDecimal nrCargaHoraria) {
        this.nrCargaHoraria = nrCargaHoraria;
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

        if (idDisciplina != null ? !idDisciplina.equals(that.idDisciplina) : that.idDisciplina != null) return false;
        if (nmDisciplina != null ? !nmDisciplina.equals(that.nmDisciplina) : that.nmDisciplina != null) return false;
        if (nrCargaHoraria != null ? !nrCargaHoraria.equals(that.nrCargaHoraria) : that.nrCargaHoraria != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDisciplina != null ? idDisciplina.hashCode() : 0;
        result = 31 * result + (nmDisciplina != null ? nmDisciplina.hashCode() : 0);
        result = 31 * result + (nrCargaHoraria != null ? nrCargaHoraria.hashCode() : 0);
        return result;
    }

    public CursoEntity getCurso() {
        return curso;
    }

    public void setCurso(CursoEntity cursoByIdCurso) {
        this.curso = cursoByIdCurso;
    }
}
