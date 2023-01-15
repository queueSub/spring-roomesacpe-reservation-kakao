package nextstep.domain.dto.theme;

public class UpdateThemeDto {
    private final Long id;
    private final String name;
    private final String desc;
    private final Integer price;

    public UpdateThemeDto(Long id, String name, String desc, Integer price) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getPrice() {
        return price;
    }
}