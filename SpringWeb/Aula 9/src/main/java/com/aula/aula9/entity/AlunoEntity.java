package com.aula.aula9.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "aluno")
public class AlunoEntity {

    @Id
    @Column(name = "id_aluno")
    private Integer id;

    @Column(name = "nm_aluno")
    private String nome;

    @Column(name = "nr_cpf")
    private Integer cpf;

    @Column(name = "dt_nascimento")
    private Date nascimento;

    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "id_aluno"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina")
    )
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

    public void setId(Integer idAluno) {
        this.id = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nmAluno) {
        this.nome = nmAluno;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer nrCpf) {
        this.cpf = nrCpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date dtNascimento) {
        this.nascimento = dtNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlunoEntity that = (AlunoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (nascimento != null ? !nascimento.equals(that.nascimento) : that.nascimento != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (nascimento != null ? nascimento.hashCode() : 0);
        return result;
    }
}
