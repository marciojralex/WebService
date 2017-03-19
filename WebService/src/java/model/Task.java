package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "task")
@XmlRootElement
public class Task {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "status")
    private boolean status;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "criacao")
    private Date criacao;
    @Column(name = "edicao")
    private Date edicao;
    @Column(name = "remocao")
    private Date remocao;
    @Column(name = "conclusao")
    private Date conclusao;

    public Task() {
    }
    
    private Task(TaskBuilder taskBuilder) {
        this.id = taskBuilder.id;
        this.titulo = taskBuilder.titulo;
        this.status = taskBuilder.status;
        this.descricao = taskBuilder.descricao;
        this.criacao = taskBuilder.criacao;
        this.edicao = taskBuilder.edicao;
        this.remocao = taskBuilder.remocao;
        this.conclusao = taskBuilder.conclusao;
    }

    public static class TaskBuilder {

        private int id;
        private String titulo;
        private boolean status;
        private String descricao;
        private Date criacao;
        private Date edicao;
        private Date remocao;
        private Date conclusao;

        public TaskBuilder(String titulo) {
            this.titulo = titulo;
        }

        public TaskBuilder id(int id) {
            this.id = id;
            return this;
        }

        public TaskBuilder status(boolean status) {
            this.status = status;
            return this;
        }

        public TaskBuilder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public TaskBuilder criacao(Date criacao) {
            this.criacao = criacao;
            return this;
        }

        public TaskBuilder edicao(Date edicao) {
            this.edicao = edicao;
            return this;
        }

        public TaskBuilder remocao(Date remocao) {
            this.remocao = remocao;
            return this;
        }

        public TaskBuilder conclusao(Date conclusao) {
            this.conclusao = conclusao;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getEdicao() {
        return edicao;
    }

    public void setEdicao(Date edicao) {
        this.edicao = edicao;
    }

    public Date getRemocao() {
        return remocao;
    }

    public void setRemocao(Date remocao) {
        this.remocao = remocao;
    }

    public Date getConclusao() {
        return conclusao;
    }

    public void setConclusao(Date conclusao) {
        this.conclusao = conclusao;
    }

}
