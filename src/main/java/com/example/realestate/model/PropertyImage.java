package com.example.realestate.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "property_images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyImage extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "caption")
    private String caption;

    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "is_primary", nullable = false)
    private Boolean isPrimary = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PropertyImage)) return false;
        return id != null && id.equals(((PropertyImage) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getWebPath() {
        if (url != null) {
            String fileName = url;
            if (url.contains("\\")) {
                fileName = url.substring(url.lastIndexOf("\\") + 1);
            } else if (url.contains("/")) {
                fileName = url.substring(url.lastIndexOf("/") + 1);
            }
            return "/web/assets/img/" + fileName;
        }
        return "/web/assets/img/test1.jpg";
    }
}
