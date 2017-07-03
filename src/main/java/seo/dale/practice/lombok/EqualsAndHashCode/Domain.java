package seo.dale.practice.lombok.EqualsAndHashCode;

import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.Date;

@EqualsAndHashCode
@Setter
public class Domain {

    private Long id;

    private Date createdBy;

}
