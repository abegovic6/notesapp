package ba.academy.notes.dto;

import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class AccountDto {
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;

    private List<GroupsDto> groupsDtoList;
    private List<LabelDto> labelDtoList;


    public Integer getId() {
        return id;
    }

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

    public List<GroupsDto> getGroupsDtoList() {
        return groupsDtoList;
    }

    public void setGroupsDtoList(List<GroupsDto> groupsDtoList) {
        this.groupsDtoList = groupsDtoList;
    }

    public List<LabelDto> getLabelDtoList() {
        return labelDtoList;
    }

    public void setLabelDtoList(List<LabelDto> labelDtoList) {
        this.labelDtoList = labelDtoList;
    }
}
