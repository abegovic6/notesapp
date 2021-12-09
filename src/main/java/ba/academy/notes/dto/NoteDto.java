package ba.academy.notes.dto;

import java.util.List;

public class NoteDto {
    private Integer id;
    private String title;
    private String description;
    private Color color;
    private List<LabelDto> labelDtoList;
    private GroupsDto groupsDto;

    public Integer getId() {
        return id;
    }

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

    public List<LabelDto> getLabelDtoList() {
        return labelDtoList;
    }

    public void setLabelDtoList(List<LabelDto> labelDtoList) {
        this.labelDtoList = labelDtoList;
    }

    public GroupsDto getGroupsDto() {
        return groupsDto;
    }

    public void setGroupsDto(GroupsDto groupsDto) {
        this.groupsDto = groupsDto;
    }
}
