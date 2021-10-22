@RelationshipEntity("IS_FOLLOWING")
@Builder
public class Friendship {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private User startNode;

    @EndNode
    private User endNode;
}