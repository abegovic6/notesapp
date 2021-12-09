package ba.academy.notes.repository.entities;

import ba.academy.notes.dto.Color;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(schema = "notes", name = "NOTE")
public class NoteEntity extends AbstractEntity<Integer>{

    @SequenceGenerator(
            name = "noteSeq",
            sequenceName = "NOTE_SEQ",
            schema = "notes",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noteSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
            schema = "notes",
            name = "NOTE_LABEL",
            joinColumns = @JoinColumn(name = "NOTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "LABEL_ID"))
    private Set<LabelEntity> labels = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="GROUPS_ID", nullable=false)
    private GroupsEntity group;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @NotNull
    @Column(name = "COLOR", nullable = false)
    private Color color;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Set<LabelEntity> getLabels() {
        return labels;
    }

    public void setLabels(Set<LabelEntity> labels) {
        this.labels = labels;
    }

    public GroupsEntity getGroup() {
        return group;
    }

    public void setGroup(GroupsEntity group) {
        this.group = group;
    }
}
