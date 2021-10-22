public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findByUserId(String userId);
    Optional<User> findByUsername(String username);

    @Query("MATCH (n)-[r]->() where n.username={0} RETURN COUNT(r)")
    Long findOutDegree(String username);

    @Query("MATCH (n)<-[r]-() where n.username={0} RETURN COUNT(r)")
    Long findInDegree(String username);

    @Query("MATCH (n1:User{ username:{0} }), (n2:User{username:{1} }) RETURN EXISTS((n1)-[:IS_FOLLOWING]->(n2))")
    boolean isFollowing(String userA, String userB);

    @Query("MATCH (n:User{username:{0}})<--(f:User) Return f")
    List<User> findFollowers(String username);

    @Query(value = "MATCH (n:User{username:{0}})<--(f:User) Return f",
            countQuery = "MATCH (n:User{username:{0}})<--(f:User) Return count(f)")
    Page<User> findFollowers(String username, Pageable pageable);

    @Query("MATCH (n:User{username:{0}})-->(f:User) Return f")
    List<User> findFollowing(String username);

}