package ba.academy.notes.repository.entities;

import ba.academy.notes.dto.Color;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "notes", name = "LABEL")
public class LabelEntity extends AbstractEntity<Integer>{

    @SequenceGenerator(
            name = "labelSeq",
            sequenceName = "LABEL_SEQ",
            schema = "notes",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "labelSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @ManyToMany(mappedBy = "labels")
    private Set<NoteEntity> notes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", nullable=false)
    private AccountEntity account;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @NotNull
    @Column(name = "COLOR", nullable = false)
    private Color color;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<NoteEntity> getNotes() {
        return notes;
    }

    public void setNotes(Set<NoteEntity> notes) {
        this.notes = notes;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
