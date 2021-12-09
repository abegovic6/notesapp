package ba.academy.notes.repository.entities;

import ba.academy.notes.dto.GroupsDto;
import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(schema = "notes", name = "ACCOUNT")
public class AccountEntity extends AbstractEntity<Integer>{

    @SequenceGenerator(
            name = "accountSeq",
            sequenceName = "ACCOUNT_SEQ",
            schema = "notes",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accountSeq")
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @OneToMany(mappedBy = "account")
    private Set<GroupsEntity> groups;

    @OneToMany(mappedBy = "account")
    private Set<LabelEntity> labels;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<GroupsEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupsEntity> groups) {
        this.groups = groups;
    }

    public Set<LabelEntity> getLabels() {
        return labels;
    }

    public void setLabels(Set<LabelEntity> labels) {
        this.labels = labels;
    }
}
